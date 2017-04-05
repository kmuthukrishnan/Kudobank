package com.newrubric.kudobank;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.skife.jdbi.v2.DBI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.storage.Storage;
import com.google.cloud.storage.StorageOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseCredentials;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.newrubric.kudobank.configuration.KudoBankConfiguration;
import com.newrubric.kudobank.dao.ILcsaDAO;
import com.newrubric.kudobank.dao.IQuestionsDao;
import com.newrubric.kudobank.dao.IQnImageDao;
import com.newrubric.kudobank.dao.ITopicDAO;
import com.newrubric.kudobank.resources.Question;
import com.newrubric.kudobank.resources.SearchTag;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Environment;

public class KudoBankApplication extends Application<KudoBankConfiguration>{
	private static final Logger logger = LoggerFactory.getLogger(KudoBankApplication.class);
	
	public static void main(String[] args) throws Exception {
		logger.info("starting the NRServer");
		new KudoBankApplication().run(args);
	}	
	@Override
    public String getName() {
		return "NR Firebse Integration Server";
	}	
	@Override
	public void run(KudoBankConfiguration config, Environment environment) throws Exception {
		Storage firebaseGoogleCloudStorage = getFireBaseCloudStorage(config);
		FirebaseDatabase defaultDatabase = getFirebaseDatabase(config);
		DatabaseReference fbDBRef =  defaultDatabase.getReference("questions");
		DatabaseReference fbSearchDBRef =  defaultDatabase.getReference("searchTags");
		
		
//		environment.jersey().setUrlPattern("/giis/*");
		
		final DBIFactory factory = new DBIFactory();
		
		DBI nrDBInterface = factory.build(environment, config.getDataSourceFactory(),"database");
		ILcsaDAO lcsaDAO = nrDBInterface.onDemand(ILcsaDAO.class);
		ITopicDAO topicDAO = nrDBInterface.onDemand(ITopicDAO.class);
		IQuestionsDao mcqDAO = nrDBInterface.onDemand(IQuestionsDao.class);
		IQnImageDao qnImageDao = nrDBInterface.onDemand(IQnImageDao.class);
		final Question question = new Question(defaultDatabase,fbDBRef,firebaseGoogleCloudStorage, config,null,topicDAO,lcsaDAO,mcqDAO,qnImageDao );
		environment.jersey().register(question);

		final SearchTag search = new SearchTag(defaultDatabase,fbSearchDBRef,config,null,topicDAO,lcsaDAO, mcqDAO);
		environment.jersey().register(search);
		
	}

	private FirebaseDatabase getFirebaseDatabase(KudoBankConfiguration config) throws FileNotFoundException{

		FileInputStream serviceAccount = new FileInputStream(config.getFirebaseCredential());

		FirebaseOptions options = new FirebaseOptions.Builder()
				  .setCredential(FirebaseCredentials.fromCertificate(serviceAccount))
				  .setDatabaseUrl(config.getFirebaseDBURL())
				  .build();
		
		FirebaseApp fbKudoConnectApp = FirebaseApp.initializeApp(options);
		FirebaseAuth defaultAuth = FirebaseAuth.getInstance(fbKudoConnectApp);
		FirebaseDatabase defaultDatabase = FirebaseDatabase.getInstance(fbKudoConnectApp);

		return defaultDatabase;
	}
	
	private Storage getFireBaseCloudStorage(KudoBankConfiguration config) throws IOException{
	
		Storage firebaseGoogleCloudStorage = StorageOptions.newBuilder()
				.setCredentials(ServiceAccountCredentials.fromStream(new FileInputStream(config.getGoogleCloudStorageCredential())))
				.setProjectId(config.getGoogleCloudStorageProjectId())
				.build().getService();			
		return firebaseGoogleCloudStorage;
	}		
}
