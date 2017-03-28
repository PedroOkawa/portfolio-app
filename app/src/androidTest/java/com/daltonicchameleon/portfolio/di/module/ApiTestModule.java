package com.daltonicchameleon.portfolio.di.module;

import com.daltonicchameleon.portfolio.di.base.ApiModule;
import com.daltonicchameleon.portfolio.util.api.ApiService;

import retrofit2.Retrofit;

import static org.mockito.Mockito.mock;

/**
 * portfolio-app
 * Created in 3/28/17 by the following authors:
 * Pedro Okawa
 */
public class ApiTestModule extends ApiModule {

    @Override
    public ApiService providesApiService(Retrofit retrofit) {
        return mock(ApiService.class);
    }

}