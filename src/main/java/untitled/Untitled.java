package untitled;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import untitled.event.forgeListener.ForgeClientListener;
import untitled.event.system.Event;
import untitled.event.system.EventRegister;
import untitled.initializeable.InitializeInitialize;

@Mod(Untitled.CLIENT_NAME)
public class Untitled {

    public static final String CLIENT_NAME = "untitled", CLIENT_VERSION = ".01";

    private static final Logger LOGGER = LogManager.getLogger();

    public static Untitled singleton;

    private InitializeInitialize initialize;

    public EventRegister<Event> eventRegister;

    public Untitled() {
        singleton = this;
        this.register();
    }

    private void initialize(final FMLCommonSetupEvent event) {
        LOGGER.info("Initialized " + CLIENT_NAME);
        this.eventRegister = new EventRegister<>();
        initialize = new InitializeInitialize();
    }

    private void register() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::initialize);
        MinecraftForge.EVENT_BUS.register(this);
        MinecraftForge.EVENT_BUS.register(new ForgeClientListener());
    }

}