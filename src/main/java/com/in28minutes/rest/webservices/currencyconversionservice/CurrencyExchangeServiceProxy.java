/**
 * 
 */
package com.in28minutes.rest.webservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.in28minutes.rest.webservices.currencyconversionservice.bean.CurrencyConversionBean;

/**
 * @author <a href=mailto:support@aeronomos.org>aeronomos</a>
 * 
 *         Please document me!!
 */
@FeignClient(name = "currency-exchange-service", url = "mbpro:8000")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(
			@PathVariable("from") String from, @PathVariable("to") String to);

}
