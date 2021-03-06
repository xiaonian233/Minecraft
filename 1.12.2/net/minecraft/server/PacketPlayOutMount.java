package net.minecraft.server;

import java.io.IOException;
import java.util.List;

public class PacketPlayOutMount implements Packet<PacketListenerPlayOut> {

    private int a;
    private int[] b;

    public PacketPlayOutMount() {}

    public PacketPlayOutMount(Entity entity) {
        this.a = entity.getId();
        List list = entity.bF();

        this.b = new int[list.size()];

        for (int i = 0; i < list.size(); ++i) {
            this.b[i] = ((Entity) list.get(i)).getId();
        }

    }

    public void a(PacketDataSerializer packetdataserializer) throws IOException {
        this.a = packetdataserializer.g();
        this.b = packetdataserializer.b();
    }

    public void b(PacketDataSerializer packetdataserializer) throws IOException {
        packetdataserializer.d(this.a);
        packetdataserializer.a(this.b);
    }

    public void a(PacketListenerPlayOut packetlistenerplayout) {
        packetlistenerplayout.a(this);
    }
}
