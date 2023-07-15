package xyz.hooy.detail.remote.server;

import lombok.RequiredArgsConstructor;
import xyz.hooy.detail.api.remote.DetailRemote;
import xyz.hooy.detail.api.entity.Detail;
import xyz.hooy.detail.service.DetailService;

@RequiredArgsConstructor
public class DetailRemoteServer implements DetailRemote {

    private final DetailService detailService;

    @Override
    public Detail getDetailById(Long id) {
        return detailService.getDetailById(id);
    }

    @Override
    public String getDetailNameById(Long id) {
        return detailService.getDetailNameById(id);
    }

    @Override
    public String getDetailIntroductionById(Long id) {
        return detailService.getDetailIntroductionById(id);
    }

    @Override
    public Detail getDetailByOrderId(Long orderId) {
        return detailService.getDetailByOrderId(orderId);
    }
}
