package br.com.authentication.api.event;

import javax.servlet.http.HttpServletResponse;

public class ResourceCreateEvent {

	/* private static final long serialVersionUID = 1L; */

	private HttpServletResponse response;
	private Long id;

	public ResourceCreateEvent(Object source, HttpServletResponse response, Long id) {
		super();
		this.response = response;
		this.id = id;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public Long getId() {
		return id;
	}

}
