package ls.miche.minecraft;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MagicWandMod implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("magicwand-mod");

    @Override
    public void onInitialize() {
        LOGGER.info("onInitialize()");
    }
}
