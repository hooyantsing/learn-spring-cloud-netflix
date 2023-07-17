package xyz.hooy.detail.remote.client;

import org.springframework.cloud.openfeign.FeignClient;
import xyz.hooy.comment.api.remote.CommentRemote;

@FeignClient("comment-service")
public interface CommentRemoteClient extends CommentRemote {
}
