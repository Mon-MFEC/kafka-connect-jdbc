package io.confluent.connect.jdbc.containers;


import org.jetbrains.annotations.NotNull;
import org.testcontainers.containers.FixedHostPortGenericContainer;
import org.testcontainers.containers.InternetProtocol;

public class FixedHostPortGenericContainerImpl extends FixedHostPortGenericContainer<FixedHostPortGenericContainerImpl> {
    /**
     * @param dockerImageName
     * @deprecated it is highly recommended that {@link FixedHostPortGenericContainer} not be used, as it risks port conflicts.
     */
    @Deprecated
    public FixedHostPortGenericContainerImpl(@NotNull String dockerImageName) {
        super(dockerImageName);
    }
    @Override
    public FixedHostPortGenericContainerImpl withFixedExposedPort(int hostPort, int containerPort) {
        return withFixedExposedPort(hostPort, containerPort, InternetProtocol.TCP);
    }

    /**
     * Bind a fixed port on the docker host to a container port
     * @param hostPort          a port on the docker host, which must be available
     * @param containerPort     a port in the container
     * @param protocol          an internet protocol (tcp or udp)
     * @return                  this container
     */
    @Override
    public FixedHostPortGenericContainerImpl withFixedExposedPort(int hostPort, int containerPort, InternetProtocol protocol) {
        super.addFixedExposedPort(hostPort, containerPort, protocol);
        return this;
    }
    @Override
    public FixedHostPortGenericContainerImpl withEnv(String key, String value) {
        this.addEnv(key, value);
        return this;
    }

}
