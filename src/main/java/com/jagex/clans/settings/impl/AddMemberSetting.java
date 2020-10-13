package com.jagex.clans.settings.impl;

import com.jagex.JagexNode;
import com.jagex.ClanSetting;
import com.jagex.clans.ClanChannel;
import com.jagex.clans.ClanChannelMember;

public class AddMemberSetting extends ClanSetting {

    String username;
    int worldId;
    byte rank;

    public AddMemberSetting() {
        username = null;
    }

    @Override
    public void apply(ClanChannel channel) {
        ClanChannelMember member = new ClanChannelMember();
        member.name = username;
        member.world = worldId;
        member.rank = rank;
        channel.addMember(member);
    }

    @Override
    public void readSettings(JagexNode buffer) {
        if (buffer.readUnsignedByte() != 255) {
            --buffer.index;
            buffer.readLong();
        }
        username = buffer.readNullString();
        worldId = buffer.readJagexNode();
        rank = buffer.readByte();
        buffer.readLong();
    }

}
