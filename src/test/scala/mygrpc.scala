import com.github.phisgr.gatling.grpc.Predef._
import com.github.phisgr.gatling.grpc.protocol.StaticGrpcProtocol

package object mygrpc {
  val grpcHost: String = "devnet1-htz-nbg1-1.wavesnodes.com"
  val grpcPort: Int    = 6871

  val grpcProtocol: StaticGrpcProtocol = grpc(managedChannelBuilder(grpcHost, grpcPort).usePlaintext())
}
