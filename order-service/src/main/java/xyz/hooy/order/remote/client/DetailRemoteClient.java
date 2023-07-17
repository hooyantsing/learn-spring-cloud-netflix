package xyz.hooy.order.remote.client;

import org.springframework.cloud.openfeign.FeignClient;
import xyz.hooy.detail.api.remote.DetailRemote;

@FeignClient("detail-service")
public interface DetailRemoteClient extends DetailRemote {
}
