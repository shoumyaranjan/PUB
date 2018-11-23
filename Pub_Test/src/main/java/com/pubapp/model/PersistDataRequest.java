package com.pubapp.model;

import com.pubapp.util.Action;

public class PersistDataRequest {
	
	private NewUser newuser;
	private Action useraction;

	public Action getUseraction() {
		return useraction;
	}

	public void setUseraction(Action useraction) {
		this.useraction = useraction;
	}

	public NewUser getNewuser() {
		return newuser;
	}

	public void setNewuser(NewUser newuser) {
		this.newuser = newuser;
	}

	
	
	

}
