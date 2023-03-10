package untitled.module.modules;

import untitled.Untitled;
import untitled.event.events.RenderHUDEvent;
import untitled.event.system.EventListener;
import untitled.module.Module;
import untitled.module.ModuleData;
import untitled.module.ModuleType;

@ModuleData(name = "Hud", displayName = "HUD", type = ModuleType.VISUAL)
public class HudModule extends Module {

    private final EventListener<RenderHUDEvent> renderHUDEventEventListener = e -> {
        drawStringWithShadow(Untitled.CLIENT_NAME, 2, 2, -1);
    };

}
