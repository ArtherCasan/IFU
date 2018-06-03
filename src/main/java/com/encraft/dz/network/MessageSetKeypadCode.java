package com.encraft.dz.network;

import net.minecraft.world.World;



import io.netty.buffer.ByteBuf;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageSetKeypadCode implements IMessage{
	
	private static String codeToSend;
	int changeX, changeY, changeZ;
	
	public MessageSetKeypadCode(){
		
	}
	
	public MessageSetKeypadCode(int x, int y, int z, String code){
		this.codeToSend = code;
		this.changeX = x;
        this.changeY = y;
        this.changeZ = z;
	}

	public void toBytes(ByteBuf buffer) {
		//Make packet here
		 buffer.writeInt(changeX);
	     buffer.writeInt(changeY);
	     buffer.writeInt(changeZ);
		ByteBufUtils.writeUTF8String(buffer, codeToSend);
	}

	public void fromBytes(ByteBuf buffer) {
		 changeX = buffer.readInt();
	     changeY = buffer.readInt();
	     changeZ = buffer.readInt();
		this.codeToSend = ByteBufUtils.readUTF8String(buffer);
	}
	
	public static class MessageHandler implements IMessageHandler<MessageSetKeypadCode, IMessage>
    {

		@Override
        public IMessage onMessage(MessageSetKeypadCode message, MessageContext context)
        {
            if (context.getServerHandler().playerEntity != null)
            {
                if (!context.getServerHandler().playerEntity.worldObj.isRemote)
                {
                    World world = context.getServerHandler().playerEntity.worldObj;
                    int x = message.changeX, y = message.changeY, z = message.changeZ;
                    String mess = message.codeToSend;
                    
                }
            }
            return null;
        }
    }
}
