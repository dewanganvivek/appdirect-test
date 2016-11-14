package org.atl.configuration;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.vivektest.appdirect.configuration.VivekTestControllerConfiguration;
import org.vivektest.vo.NotificationVO;

/**
 * Basic integration tests for service demo application.
 *
 * @version 1.0
 * @since 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = VivekTestControllerConfiguration.class)
@WebAppConfiguration
@IntegrationTest({ "local.server.port=0", "local.management.port=0" })
@DirtiesContext
public class VivekTestConfigurationTests {

	@Value("${local.server.port}")
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Test
	public void testEndpoint() throws Exception {
		Map<String, String> reqParam = new HashMap<String, String>();
		reqParam.put("userEmail", "dewangan.vivek@gmail.com");
		final NotificationVO entity = new TestRestTemplate()
				.postForObject("http://localhost:" + port + "/read/notification/1", null,
						NotificationVO.class, reqParam);
		NotificationVO test = new NotificationVO();
		assertEquals(test, entity);
	}

	@Test
	public void testInfo() throws Exception {
		@SuppressWarnings("rawtypes")
		final ResponseEntity<Map> entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + mgt + "/info", Map.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

}
