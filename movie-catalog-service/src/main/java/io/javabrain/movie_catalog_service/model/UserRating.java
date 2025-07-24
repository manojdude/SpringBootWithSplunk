package io.javabrain.movie_catalog_service.model;

import java.util.List;

public class UserRating {

	private List<Rating> userRating;

	public UserRating() {
		super();
	}

	public UserRating(List<Rating> userrating) {
		super();
		this.userRating = userrating;
	}

	public List<Rating> getUserrating() {
		return userRating;
	}

	public void setUserrating(List<Rating> userrating) {
		this.userRating = userrating;
	}

}
