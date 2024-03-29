package tech.waves.load.wavesloadgrpc.cases

import com.github.phisgr.gatling.grpc.Predef._
import com.github.phisgr.gatling.grpc.action.GrpcCallActionBuilder
import com.google.protobuf.ByteString
import com.wavesplatform.api.grpc.{AssetInfoResponse, AssetRequest, AssetsApiGrpc}
import io.gatling.core.Predef._
import io.grpc.Status
import tech.waves.load.wavesloadgrpc.feeders.Feeders.feeder

object GrpcActions {
  val getFeature: GrpcCallActionBuilder[AssetRequest, AssetInfoResponse] =
    grpc("AssetsApi")
      .rpc(AssetsApiGrpc.METHOD_GET_INFO)
      .payload {
        AssetRequest.of(ByteString.copyFrom(feeder.next()("assetId")))
      }
      .check(statusCode is Status.Code.OK)
}
