/**
 * 
 */
package com.in28minutes.rest.webservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.in28minutes.rest.webservices.currencyconversionservice.bean.CurrencyConversionBean;

/**
 * @author <a href=mailto:support@aeronomos.org>aeronomos</a>
 * 
 *         Please document me!!
 */
@RestController
public class CurrencyConversionController {

	@Autowired
	Environment env;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {

		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);

		ResponseEntity<CurrencyConversionBean> responseEntity =
				new RestTemplate().getForEntity(
						"http://localhost:8000/currency-exchange/from/{from}/to/{to}",
						CurrencyConversionBean.class, uriVariables);
		CurrencyConversionBean currencyConversionBean = responseEntity.getBody();

		return new CurrencyConversionBean(currencyConversionBean.getId(), from, to,
				currencyConversionBean.getConversionMultiple(), quantity,
				currencyConversionBean.getTotalCalculatedAmount(),
				currencyConversionBean.getPort());
	}

}
