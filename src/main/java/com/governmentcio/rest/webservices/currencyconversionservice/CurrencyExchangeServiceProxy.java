/**
 * 
 */
package com.governmentcio.rest.webservices.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.governmentcio.rest.webservices.currencyconversionservice.bean.CurrencyConversionBean;

/**
 * 
 * @author <a href=mailto:support@governmentcio.com>support</a>
 * 
 *         Please document me!!
 */
@FeignClient(name = "netflix-zuul-api-gateway-server")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

	@GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(
			@PathVariable("from") String from, @PathVariable("to") String to);

}
