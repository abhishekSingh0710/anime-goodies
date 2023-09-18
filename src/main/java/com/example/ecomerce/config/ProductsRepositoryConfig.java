package com.example.ecomerce.config;

import com.example.ecomerce.entity.Product;
import com.example.ecomerce.entity.ProductCategory;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
@Configuration
public class ProductsRepositoryConfig implements RepositoryRestConfigurer {
    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        HttpMethod[] unsupportedTypes = {HttpMethod.DELETE, HttpMethod.PUT, HttpMethod.POST};
        config.getExposureConfiguration()
                .forDomainType(ProductCategory.class)
                .withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedTypes)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedTypes)));
        config.getExposureConfiguration()
                .forDomainType(Product.class).
                withItemExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedTypes)))
                .withCollectionExposure(((metdata, httpMethods) -> httpMethods.disable(unsupportedTypes)));

    }

}
