
import scala.concurrent.duration._

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import io.gatling.jdbc.Predef._

class PruebaLogin extends Simulation {

	val httpProtocol = http
		.baseURL("http://localhost:8082")
		.inferHtmlResources()

	val headers_0 = Map("User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36")

	val headers_1 = Map(
		"accept" -> "image/webp,image/apng,image/*,*/*;q=0.8",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "es-ES,es;q=0.9,en;q=0.8,it;q=0.7",
		"cookie" -> "SID=zwW1aEfJ83yjk1vetzpDl3DQzs8NotWQH23nm1791xNQncy9uVirzqqIJ0H2-7oFB1Qktg.; HSID=A640F6J1IjX9VMcdd; SSID=ALFpHYwhsVE6m-gXv; APISID=QeymIYN6RyD_Kgh9/AF3InuMTHv2O-C2En; SAPISID=bYHYKhFupk5J5RQI/ARkCt4qALCkfaPlbU; NID=129=imSkeRzO2Quu1crexMR1uy0bnTAuDpGAOzZ4MRyP3bXNrIu1qXOoX3oIx15lqc-eJ1hzh9X095iukMfFYidQSdroaLRFyZOKIuHguvoDswO7B4vlpKBD426h-78YWuBVOCbmgyKat1x3zWzPA-aR0VBJV4_MCkqYJ1O4fquSOqYw9NVpMcU41T_BrfVcGaTfYHYVLUH6JEhjp9YDyTG-BIteLygFk1MqTIrZ7e7bEQ0X4g; 1P_JAR=2018-4-29-16",
		"referer" -> "https://www.google.es/_/chrome/newtab?ie=UTF-8",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36",
		"x-client-data" -> "CJS2yQEIo7bJAQjBtskBCKmdygEIqKPKARitmMoBGJKjygE=")

	val headers_2 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "es-ES,es;q=0.9,en;q=0.8,it;q=0.7",
		"Connection" -> "keep-alive",
		"Upgrade-Insecure-Requests" -> "1",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36")

	val headers_8 = Map(
		"Origin" -> "http://localhost:8082",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36")

	val headers_9 = Map(
		"Accept" -> "text/css,*/*;q=0.1",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "es-ES,es;q=0.9,en;q=0.8,it;q=0.7",
		"Connection" -> "keep-alive",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36")

	val headers_18 = Map(
		"Accept" -> "image/webp,image/apng,image/*,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "es-ES,es;q=0.9,en;q=0.8,it;q=0.7",
		"Connection" -> "keep-alive",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36")

	val headers_19 = Map(
		"Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "es-ES,es;q=0.9,en;q=0.8,it;q=0.7",
		"Cache-Control" -> "max-age=0",
		"Connection" -> "keep-alive",
		"Origin" -> "http://localhost:8082",
		"Upgrade-Insecure-Requests" -> "1",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36")

	val headers_20 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "es-ES,es;q=0.9,en;q=0.8,it;q=0.7",
		"referer" -> "http://localhost:8082/dashboard",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36",
		"x-client-data" -> "CJS2yQEIo7bJAQjBtskBCKmdygEIqKPKARitmMoBGJKjygE=")

	val headers_24 = Map(
		"accept" -> "*/*",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "es-ES,es;q=0.9,en;q=0.8,it;q=0.7",
		"cookie" -> "NID=128=VC_wknRIQ2pzVw3jZ_GksvR7UB1f7fl55M0C76nGxwhvRtetPPwEv5PF-606Pepob64EeSUjjbpRLHv-DkZUT7EiJTlcd7K5YufTFuf-uOgKaFg9rsCmWkiQg0DLzWOy; CONSENT=WP.26c6f2",
		"referer" -> "http://localhost:8082/dashboard",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36",
		"x-client-data" -> "CJS2yQEIo7bJAQjBtskBCKmdygEIqKPKARitmMoBGJKjygE=")

	val headers_25 = Map(
		"accept" -> "image/webp,image/apng,image/*,*/*;q=0.8",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "es-ES,es;q=0.9,en;q=0.8,it;q=0.7",
		"cookie" -> "NID=128=VC_wknRIQ2pzVw3jZ_GksvR7UB1f7fl55M0C76nGxwhvRtetPPwEv5PF-606Pepob64EeSUjjbpRLHv-DkZUT7EiJTlcd7K5YufTFuf-uOgKaFg9rsCmWkiQg0DLzWOy; CONSENT=WP.26c6f2",
		"referer" -> "http://localhost:8082/dashboard",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36",
		"x-client-data" -> "CJS2yQEIo7bJAQjBtskBCKmdygEIqKPKARitmMoBGJKjygE=")

	val headers_27 = Map(
		"accept" -> "text/css,*/*;q=0.1",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "es-ES,es;q=0.9,en;q=0.8,it;q=0.7",
		"cookie" -> "NID=128=VC_wknRIQ2pzVw3jZ_GksvR7UB1f7fl55M0C76nGxwhvRtetPPwEv5PF-606Pepob64EeSUjjbpRLHv-DkZUT7EiJTlcd7K5YufTFuf-uOgKaFg9rsCmWkiQg0DLzWOy; CONSENT=WP.26c6f2",
		"referer" -> "http://localhost:8082/dashboard",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36",
		"x-client-data" -> "CJS2yQEIo7bJAQjBtskBCKmdygEIqKPKARitmMoBGJKjygE=")

	val headers_34 = Map(
		"Accept" -> "*/*",
		"Accept-Encoding" -> "gzip, deflate, br",
		"Accept-Language" -> "es-ES,es;q=0.9,en;q=0.8,it;q=0.7",
		"Connection" -> "keep-alive",
		"User-Agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36")

	val headers_35 = Map(
		"accept" -> "image/webp,image/apng,image/*,*/*;q=0.8",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "es-ES,es;q=0.9,en;q=0.8,it;q=0.7",
		"referer" -> "http://localhost:8082/dashboard",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36",
		"x-client-data" -> "CJS2yQEIo7bJAQjBtskBCKmdygEIqKPKARitmMoBGJKjygE=")

	val headers_48 = Map(
		"accept" -> "text/css,*/*;q=0.1",
		"accept-encoding" -> "gzip, deflate, br",
		"accept-language" -> "es-ES,es;q=0.9,en;q=0.8,it;q=0.7",
		"referer" -> "http://localhost:8082/dashboard",
		"user-agent" -> "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/66.0.3359.139 Safari/537.36",
		"x-client-data" -> "CJS2yQEIo7bJAQjBtskBCKmdygEIqKPKARitmMoBGJKjygE=")

    val uri01 = "https://maps.googleapis.com"
    val uri02 = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"
    val uri04 = "https://cdnjs.cloudflare.com/ajax/libs"
    val uri05 = "https://www.google.es/gen_204"
    val uri06 = "https://maps.gstatic.com/mapfiles"
    val uri07 = "https://fonts.gstatic.com/s/roboto/v18"
    val uri08 = "https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0"
    val uri09 = "https://www.gstatic.com/charts"
    val uri10 = "https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js"
    val uri11 = "https://fonts.googleapis.com/css"

	val scn = scenario("PruebaLogin")
		.exec(http("request_0")
			.get(uri05 + "?atyp=i&ct=nfkbx&cad=&ei=rIzkWpvTM-SE6ASl9ISQBg&zx=1525019361227")
			.headers(headers_0)
			.resources(http("request_1")
			.get(uri05 + "?atyp=i&ct=nfkbx&cad=&ei=rIzkWpvTM-SE6ASl9ISQBg&zx=1525019361227")
			.headers(headers_1)))
		.pause(4)
		.exec(http("request_2")
			.get("/")
			.headers(headers_2)
			.resources(http("request_3")
			.get(uri02 + "")
			.headers(headers_0),
            http("request_4")
			.get(uri08 + "/js/bootstrap.min.js")
			.headers(headers_0),
            http("request_5")
			.get(uri09 + "/loader.js")
			.headers(headers_0),
            http("request_6")
			.get(uri04 + "/sockjs-client/1.1.4/sockjs.min.js")
			.headers(headers_0),
            http("request_7")
			.get(uri04 + "/stomp.js/2.3.3/stomp.min.js")
			.headers(headers_0),
            http("request_8")
			.get(uri08 + "/css/bootstrap.min.css")
			.headers(headers_8),
            http("request_9")
			.get("/css/custom.css")
			.headers(headers_9)))
		.pause(18)
		.exec(http("request_10")
			.get("/login")
			.headers(headers_2)
			.resources(http("request_11")
			.get(uri02 + ""),
            http("request_12")
			.get(uri08 + "/js/bootstrap.min.js"),
            http("request_13")
			.get(uri09 + "/loader.js"),
            http("request_14")
			.get(uri04 + "/sockjs-client/1.1.4/sockjs.min.js"),
            http("request_15")
			.get(uri04 + "/stomp.js/2.3.3/stomp.min.js"),
            http("request_16")
			.get(uri08 + "/css/bootstrap.min.css")
			.headers(headers_8),
            http("request_17")
			.get("/css/custom.css")
			.headers(headers_9),
            http("request_18")
			.get("/img/operator.png")
			.headers(headers_18)))
		.pause(9)
		.exec(http("request_19")
			.post("/login")
			.headers(headers_19)
			.formParam("username", "fireman1@gmail.com")
			.formParam("password", "123456")
			.resources(http("request_20")
			.get(uri01 + "/maps-api-v3/api/js/32/12/intl/es_ALL/common.js")
			.headers(headers_20),
            http("request_21")
			.get(uri01 + "/maps-api-v3/api/js/32/12/intl/es_ALL/util.js")
			.headers(headers_20),
            http("request_22")
			.get(uri01 + "/maps-api-v3/api/js/32/12/intl/es_ALL/map.js")
			.headers(headers_20),
            http("request_23")
			.get(uri01 + "/maps-api-v3/api/js/32/12/intl/es_ALL/overlay.js")
			.headers(headers_20),
            http("request_24")
			.get(uri09 + "/45.2/loader.js")
			.headers(headers_24)))
		.pause(2)
		.exec(http("request_25")
			.get(uri06 + "/openhand_8_8.cur")
			.headers(headers_25)
			.resources(http("request_26")
			.get(uri01 + "/maps-api-v3/api/js/32/12/intl/es_ALL/onion.js")
			.headers(headers_20),
            http("request_27")
			.get(uri09 + "/45.2/css/core/tooltip.css")
			.headers(headers_27),
            http("request_28")
			.get(uri09 + "/45.2/css/util/util.css")
			.headers(headers_27),
            http("request_29")
			.get(uri09 + "/45.2/js/jsapi_compiled_format_module.js")
			.headers(headers_24),
            http("request_30")
			.get(uri09 + "/45.2/js/jsapi_compiled_default_module.js")
			.headers(headers_24),
            http("request_31")
			.get(uri09 + "/45.2/js/jsapi_compiled_ui_module.js")
			.headers(headers_24),
            http("request_32")
			.get(uri09 + "/45.2/js/jsapi_compiled_corechart_module.js")
			.headers(headers_24),
            http("request_33")
			.get(uri01 + "/maps/api/js/ViewportInfoService.GetViewportInfo?1m6&1m2&1d19.98523605787963&2d-77.27624609046791&2m2&1d61.28805724416419&2d63.9527553852148&2u5&4ses-ES&5e0&6sm%40420000000&7b0&8e0&callback=_xdc_._qbvdpv&token=126008")
			.headers(headers_20),
            http("request_34")
			.get("/dashboard/info?t=1525019399727")
			.headers(headers_34),
            http("request_35")
			.get(uri01 + "/maps/vt?pb=!1m5!1m4!1i5!2i15!3i12!4i256!2m3!1e0!2sm!3i420120104!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=14498")
			.headers(headers_35),
            http("request_36")
			.get(uri01 + "/maps/vt?pb=!1m5!1m4!1i5!2i14!3i12!4i256!2m3!1e0!2sm!3i420120104!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=83607")
			.headers(headers_35),
            http("request_37")
			.get(uri01 + "/maps/vt?pb=!1m5!1m4!1i5!2i14!3i11!4i256!2m3!1e0!2sm!3i420120104!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=78786")
			.headers(headers_35),
            http("request_38")
			.get(uri01 + "/maps/vt?pb=!1m5!1m4!1i5!2i15!3i11!4i256!2m3!1e0!2sm!3i420120104!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=9677")
			.headers(headers_35),
            http("request_39")
			.get(uri01 + "/maps/vt?pb=!1m5!1m4!1i5!2i16!3i11!4i256!2m3!1e0!2sm!3i420120104!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=71639")
			.headers(headers_35),
            http("request_40")
			.get(uri01 + "/maps/vt?pb=!1m5!1m4!1i5!2i16!3i12!4i256!2m3!1e0!2sm!3i420120104!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=76460")
			.headers(headers_35),
            http("request_41")
			.get(uri01 + "/maps/vt?pb=!1m5!1m4!1i5!2i13!3i12!4i256!2m3!1e0!2sm!3i420119996!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=127543")
			.headers(headers_35),
            http("request_42")
			.get(uri01 + "/maps/vt?pb=!1m5!1m4!1i5!2i13!3i11!4i256!2m3!1e0!2sm!3i420119948!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=10814")
			.headers(headers_35),
            http("request_43")
			.get(uri01 + "/maps/vt?pb=!1m5!1m4!1i5!2i17!3i11!4i256!2m3!1e0!2sm!3i420120104!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=2530")
			.headers(headers_35),
            http("request_44")
			.get(uri01 + "/maps/vt?pb=!1m5!1m4!1i5!2i17!3i12!4i256!2m3!1e0!2sm!3i420120104!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e0!23i1301875&token=7351")
			.headers(headers_35),
            http("request_45")
			.get(uri01 + "/maps/vt?pb=!1m4!1m3!1i5!2i13!3i11!1m4!1m3!1i5!2i14!3i11!1m4!1m3!1i5!2i15!3i11!1m4!1m3!1i5!2i13!3i12!1m4!1m3!1i5!2i14!3i12!1m4!1m3!1i5!2i15!3i12!1m4!1m3!1i5!2i16!3i11!1m4!1m3!1i5!2i17!3i11!1m4!1m3!1i5!2i16!3i12!1m4!1m3!1i5!2i17!3i12!2m3!1e0!2sm!3i420120104!3m9!2ses-ES!3sUS!5e18!12m1!1e68!12m3!1e37!2m1!1ssmartmaps!4e3!12m1!5b1!23i1301875&callback=_xdc_._8eqh47&token=75364")
			.headers(headers_20)))
		.pause(1)
		.exec(http("request_46")
			.get(uri01 + "/maps-api-v3/api/js/32/12/intl/es_ALL/controls.js")
			.headers(headers_20)
			.resources(http("request_47")
			.get(uri01 + "/maps/api/js/AuthenticationService.Authenticate?1shttp%3A%2F%2Flocalhost%3A8082%2Fdashboard&4sAIzaSyBAr9ogXGdZ9_qScXx3Pd8Rg0Kv5TuSV_U&callback=_xdc_._jloyba&token=54160")
			.headers(headers_20),
            http("request_48")
			.get(uri11 + "?family=Roboto:300,400,500,700")
			.headers(headers_48),
            http("request_49")
			.get(uri06 + "/transparent.png")
			.headers(headers_25),
            http("request_50")
			.get(uri06 + "/api-3/images/google4.png")
			.headers(headers_25),
            http("request_51")
			.get(uri06 + "/api-3/images/mapcnt6.png")
			.headers(headers_25),
            http("request_52")
			.get(uri06 + "/api-3/images/sv9.png")
			.headers(headers_25),
            http("request_53")
			.get(uri01 + "/maps-api-v3/api/js/32/12/intl/es_ALL/marker.js")
			.headers(headers_20),
            http("request_54")
			.get(uri06 + "/api-3/images/tmapctrl.png")
			.headers(headers_25),
            http("request_55")
			.get(uri06 + "/api-3/images/cb_scout5.png")
			.headers(headers_25),
            http("request_56")
			.get(uri06 + "/api-3/images/tmapctrl4.png")
			.headers(headers_25),
            http("request_57")
			.get(uri06 + "/mv/imgs8.png")
			.headers(headers_25),
            http("request_58")
			.get(uri07 + "/KFOmCnqEu92Fr1Mu4mxK.woff2")
			.headers(headers_8),
            http("request_59")
			.get(uri07 + "/KFOlCnqEu92Fr1MmEU9fBBc4.woff2")
			.headers(headers_8)))
		.pause(3)
		.exec(http("request_60")
			.get(uri01 + "/maps-api-v3/api/js/32/12/intl/es_ALL/stats.js")
			.headers(headers_20))
		.pause(1)
		.exec(http("request_61")
			.get(uri01 + "/maps/api/js/QuotaService.RecordEvent?1shttp%3A%2F%2Flocalhost%3A8082%2Fdashboard&3sAIzaSyBAr9ogXGdZ9_qScXx3Pd8Rg0Kv5TuSV_U&7sl16hb4&10e1&callback=_xdc_._2ys138&token=107356")
			.headers(headers_20))

	setUp(scn.inject(atOnceUsers(10))).protocols(httpProtocol)
}