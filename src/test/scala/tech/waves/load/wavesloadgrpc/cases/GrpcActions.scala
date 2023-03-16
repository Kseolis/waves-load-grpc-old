package tech.waves.load.wavesloadgrpc.cases

import com.github.phisgr.gatling.grpc.Predef._
import com.github.phisgr.gatling.grpc.action.GrpcCallActionBuilder
import com.wavesplatform.api.grpc.{AssetInfoResponse, AssetRequest, AssetsApiGrpc}
import com.wavesplatform.crypto.base.Base64
import io.gatling.core.Predef._
import io.grpc.Status


object GrpcActions {
 val assetId: Array[Byte] = Base64.decode("aGMxZMlRCKPavshL7mtimuBH0jKIiMsy7+FD1ACTwW0=")

  val getFeature: GrpcCallActionBuilder[AssetRequest, AssetInfoResponse] =
    grpc("AssetsApi")
      .rpc(AssetsApiGrpc.METHOD_GET_INFO)
      .payload {
        "#{assetId}"
      }
      .check(statusCode is Status.Code.OK)
}