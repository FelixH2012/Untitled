package untitled.hook;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;

public interface MinecraftHook {

    Minecraft mc = Minecraft.getInstance();

    default void drawString(final String text, final int x, final int y, final int color) {
        mc.font.draw(new PoseStack(), text, x, y, color);
    }

    default void drawStringWithShadow(final String text, final int x, final int y, final int color) {
        mc.font.draw(new PoseStack(), text, x, y, color);
        mc.font.drawShadow(new PoseStack(), text, x, y, color);
    }

}
