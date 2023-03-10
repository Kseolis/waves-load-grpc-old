package tech.waves.load.wavesloadgrpc.cases

import com.github.phisgr.gatling.grpc.Predef._
import com.github.phisgr.gatling.grpc.action.GrpcCallActionBuilder
import com.google.protobuf.ByteString
import com.wavesplatform.api.grpc.{AssetInfoResponse, AssetRequest, AssetsApiGrpc}
import com.wavesplatform.crypto.base.Base58
import io.gatling.core.Predef._
import io.gatling.core.session.Expression
import io.grpc.Status

object GrpcActions {
  val assetId: Array[Byte] = Base58.decode("aGMxZMlRCKPavshL7mtimuBH0jKIiMsy7+FD1ACTwW0=")

  val message: Expression[AssetRequest] = AssetRequest.of(ByteString.copyFrom(assetId))

  val getFeature: GrpcCallActionBuilder[AssetRequest, AssetInfoResponse] =
    grpc("AssetsApi")
      .rpc(AssetsApiGrpc.METHOD_GET_INFO)
      .payload {
        message
      }
      .check(statusCode is Status.Code.OK)
}