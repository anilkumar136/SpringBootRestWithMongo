package com.example.demo;

import com.example.demo.filter.RequestResponseLoggingFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.ShallowEtagHeaderFilter;

import javax.servlet.Filter;

@SpringBootApplication
@EnableCaching
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean    //This is to polulate Etag
	public Filter getFilter(){
		return new ShallowEtagHeaderFilter();
	}

	@Bean   //TO add any filter for any specific url pattern
	public FilterRegistrationBean<RequestResponseLoggingFilter> loggingFilter(){
		FilterRegistrationBean<RequestResponseLoggingFilter> registrationBean
				= new FilterRegistrationBean<>();

		registrationBean.setFilter(new RequestResponseLoggingFilter());
		registrationBean.addUrlPatterns("/api/*");
		registrationBean.setOrder(2);

		return registrationBean;
	}


	////EhCache Beans requred with XML
//	@Bean
//	public EhCacheManagerFactoryBean cacheManager() {
//		return new EhCacheManagerFactoryBean();
//	}

//	@Bean
//	public EhCacheCacheManager testEhCacheManager() {
//		// testEhCache Configuration - create configuration of cache that previous required XML
//		CacheConfiguration testEhCacheConfig = new CacheConfiguration()
//				.eternal(false)                     // if true, timeouts are ignored
//				.timeToIdleSeconds(3)               // time since last accessed before item is marked for removal
//				.timeToLiveSeconds(5)               // time since inserted before item is marked for removal
//				.maxEntriesLocalHeap(10)            // total items that can be stored in cache
//				.memoryStoreEvictionPolicy("LRU")   // eviction policy for when items exceed cache. LRU = Least Recently Used
//				.name("testCache");
//
//		Cache testCache = new Cache(testEhCacheConfig);
//
//
//		cacheManager().getObject().addCache(testCache);
//		return new EhCacheCacheManager(cacheManager().getObject());
//	}

}
