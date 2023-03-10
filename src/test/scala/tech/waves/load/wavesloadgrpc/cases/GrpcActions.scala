package tech.waves.load.wavesloadgrpc.cases

import com.github.phisgr.gatling.grpc.Predef._
import com.github.phisgr.gatling.grpc.action.GrpcCallActionBuilder
import com.wavesplatform.api.grpc.{AssetInfoResponse, AssetRequest, AssetsApiGrpc}
import com.wavesplatform.crypto.base.Base64
import io.gatling.core.Predef._
import io.grpc.Status

object GrpcActions {
 // val assetId: Base64 = Base64.encode("aGMxZMlRCKPavshL7mtimuBH0jKIiMsy7+FD1ACTwW0=".getBytes)


/*  val getFeature: GrpcCallActionBuilder[AssetRequest, AssetInfoResponse] =
    grpc("AssetsApi")
      .rpc(AssetsApiGrpc.METHOD_GET_INFO)
      .payload {
        AssetRequest().assetId: Base64.encode()
      }
      .check(statusCode is Status.Code.OK)*/
}