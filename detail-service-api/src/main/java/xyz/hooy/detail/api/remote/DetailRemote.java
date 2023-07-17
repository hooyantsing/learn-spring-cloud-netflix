package xyz.hooy.detail.api.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.hooy.detail.api.entity.Detail;

@FeignClient("detail-service")
@RequestMapping("/remote/detail")
public interface DetailRemote {

    @GetMapping("/getDetailById/{id}")
    Detail getDetailById(@PathVariable("id") Long id);

    @GetMapping("/getDetailNameById/{id}")
    String getDetailNameById(@PathVariable("id") Long id);

    @GetMapping("/getDetailIntroductionById/{id}")
    String getDetailIntroductionById(@PathVariable("id") Long id);

    @GetMapping("/getDetailByOrderId/{orderId}")
    Detail getDetailByOrderId(@PathVariable("orderId") Long orderId);
}
