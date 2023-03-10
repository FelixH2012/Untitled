package untitled.event.forgeListener;

import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RenderGuiOverlayEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import untitled.Untitled;
import untitled.event.events.RenderHUDEvent;

@Mod.EventBusSubscriber
public class ForgeClientListener {

    @SubscribeEvent
    public void listenToGuiOverlay(RenderGuiOverlayEvent.Post event) {
        System.out.println("Listening");
        Untitled.singleton.eventRegister.addToListen(new RenderHUDEvent());
    }

}
