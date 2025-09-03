package jolt9001.causalchaos.actions.base_impl.timeloop;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.saveddata.SavedData;

import java.util.*;

public class ChronalRewind extends SavedData {
    // Class for the Time Loop functionality

    public static final String ID = "chronal-rewind";

    public boolean active;
    public long anchorGameTime;        // when anchor was created
    public long anchorExpiryTick;      // anchorGameTime + 2_400_000
    public BlockPos anchorSpawn;       // where to place player
    public UUID boundPlayer;           // owner (or null if global)
    public CompoundTag playerInv;      // serialized inventory
    public CompoundTag playerEnder;    // ender
    public int playerXp, playerXpLevel;
    public Set<ResourceLocation> advancements = new HashSet<>();

    // Optional: world flags
    public boolean wasRaining;
    public int timeOfDay;

    // Optional (powerful): snapshots of blocks
    public List<CompoundTag> anchoredBlockEntities = new ArrayList<>();

    // Factory used by DataStorage in 1.20.2+
    public static final SavedData.Factory<ChronalRewind> FACTORY =
            new SavedData.Factory<>(ChronalRewind::new, ChronalRewind::fromNbt, null);

    public static ChronalRewind get(ServerLevel overworld) {
        return overworld.getDataStorage().computeIfAbsent(FACTORY, ID);
    }

    // Load function (must match Function<CompoundTag, LoopAnchorData>)
    private static ChronalRewind fromNbt(CompoundTag nbt) {
        ChronalRewind d = new ChronalRewind();
        d.active = nbt.getBoolean("active");
        d.anchorGameTime = nbt.getLong("anchorGameTime");
        d.anchorExpiryTick = nbt.getLong("anchorExpiryTick");
        d.anchorSpawn = NbtUtils.readBlockPos(nbt.getCompound("anchorSpawn"));
        if (nbt.hasUUID("boundPlayer")) d.boundPlayer = nbt.getUUID("boundPlayer");
        d.playerInv = nbt.getCompound("playerInv");
        d.playerEnder = nbt.getCompound("playerEnder");
        d.playerXp = nbt.getInt("playerXp");
        d.playerXpLevel = nbt.getInt("playerXpLevel");
        d.wasRaining = nbt.getBoolean("wasRaining");
        d.timeOfDay = nbt.getInt("timeOfDay");

        ListTag list = nbt.getList("adv", Tag.TAG_STRING);
        for (Tag t : list) d.advancements.add(new ResourceLocation(t.getAsString()));

        ListTag beList = nbt.getList("anchoredBEs", Tag.TAG_COMPOUND);
        for (Tag t : beList) d.anchoredBlockEntities.add((CompoundTag) t);
        return d;
    }

    @Override
    public CompoundTag save(CompoundTag nbt) {
        nbt.putBoolean("active", active);
        nbt.putLong("anchorGameTime", anchorGameTime);
        nbt.putLong("anchorExpiryTick", anchorExpiryTick);
        nbt.put("anchorSpawn", NbtUtils.writeBlockPos(anchorSpawn));
        if (boundPlayer != null) nbt.putUUID("boundPlayer", boundPlayer);
        if (playerInv != null) nbt.put("playerInv", playerInv);
        if (playerEnder != null) nbt.put("playerEnder", playerEnder);
        nbt.putInt("playerXp", playerXp);
        nbt.putInt("playerXpLevel", playerXpLevel);
        nbt.putBoolean("wasRaining", wasRaining);
        nbt.putInt("timeOfDay", timeOfDay);

        ListTag list = new ListTag();
        for (ResourceLocation rl : advancements) list.add(StringTag.valueOf(rl.toString()));
        nbt.put("adv", list);

        ListTag beList = new ListTag();
        beList.addAll(anchoredBlockEntities);
        nbt.put("anchoredBEs", beList);
        return nbt;
    }

    public void markDirty() {
        this.setDirty();
    }
}