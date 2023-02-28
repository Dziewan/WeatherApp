package com.md.weatherapp.service;

@FunctionalInterface
public interface Extractor<Request, Response> {

    Response extract(Request request);
}
