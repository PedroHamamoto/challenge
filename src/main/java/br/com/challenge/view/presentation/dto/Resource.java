package br.com.challenge.view.presentation.dto;

/**
 * Represents a item in the responses payloads
 */
public class Resource<T> {

    private final String uri;
    private final T item;

    public Resource(String uri, T item) {
        this.uri = uri;
        this.item = item;
    }

    public String getUri() {
        return uri;
    }

    public T getItem() {
        return item;
    }
}
