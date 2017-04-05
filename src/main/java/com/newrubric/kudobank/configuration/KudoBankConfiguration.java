package com.newrubric.kudobank.configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.Configuration;
import io.dropwizard.db.DataSourceFactory;

public class KudoBankConfiguration extends Configuration {
	@Valid
	@NotNull
	private String firebaseDBURL = "https://testfirebase-50e57.firebaseio.com";

	@Valid
	@NotNull
	private String firebaseCredential = "firebase-adminsdk-bvt9b-e69cfd7f6a.json";

	@Valid
	@NotNull	
	private String googleCloudStorageCredential = "TestFirebase-5765f861e76f_gcloudstorage_nr.json";
	
	@Valid
	@NotNull	
	private String googleCloudStorageProjectId = "testfirebase-50e57";
	
	private String firebaseDB = "testfirebase-50e57.appspot.com";

	@Valid
	@NotNull
	private String defaultImageLocalFolder = "C:\\tmp\\firebaseImages";

	@Valid
	@NotNull
	private DataSourceFactory database = new DataSourceFactory();

	@Valid
	@JsonProperty("jersey")
	private JerseyConfiguration jersey = new JerseyConfiguration();

	@JsonProperty("database")
	public DataSourceFactory getDataSourceFactory() {
		return database;
	}

	@JsonProperty("database")
	public void setDataSourceFactory(DataSourceFactory dataSourceFactory) {
		this.database = dataSourceFactory;
	}

	public void setJersey(JerseyConfiguration jersey) {
		this.jersey = jersey;
	}

	public JerseyConfiguration getJerseyConfiguration() {
		return jersey;
	}

	@JsonProperty("defaultImageLocalFolder")
	public String getDefaultImageLocalFolder() {
		return defaultImageLocalFolder;
	}

	@JsonProperty("defaultImageLocalFolder")
	public void setDefaultImageLocalFolder(String defaultImageLocalFolder) {
		this.defaultImageLocalFolder = defaultImageLocalFolder;
	}

	@JsonProperty("firebaseDB")
	public String getFirebaseDB() {
		return firebaseDB;
	}

	@JsonProperty("firebaseDB")
	public void setFirebaseDB(String firebaseDB) {
		this.firebaseDB = firebaseDB;
	}

	public String getFirebaseDBURL() {
		return firebaseDBURL;
	}

	public void setFirebaseDBURL(String firebaseDBURL) {
		this.firebaseDBURL = firebaseDBURL;
	}

	public String getFirebaseCredential() {
		return firebaseCredential;
	}

	public void setFirebaseCredential(String firebaseCredential) {
		this.firebaseCredential = firebaseCredential;
	}

	public String getGoogleCloudStorageCredential() {
		return googleCloudStorageCredential;
	}

	public void setGoogleCloudStorageCredential(String googleCloudStorageCredential) {
		this.googleCloudStorageCredential = googleCloudStorageCredential;
	}

	public String getGoogleCloudStorageProjectId() {
		return googleCloudStorageProjectId;
	}

	public void setGoogleCloudStorageProjectId(String googleCloudStorageProjectId) {
		this.googleCloudStorageProjectId = googleCloudStorageProjectId;
	}

	
}
