package br.com.authentication.api.controller;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.authentication.api.event.ResourceCreateEvent;

@Component
public class ResourceCreateListener {

	public void onApplicationEvent(ResourceCreateEvent resourceCreateEvent) {
		HttpServletResponse response = resourceCreateEvent.getResponse();
		Long id = resourceCreateEvent.getId();

		addHeaderLocation(response, id);
	}

	private void addHeaderLocation(HttpServletResponse response, Long id) {
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(id).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}

}
