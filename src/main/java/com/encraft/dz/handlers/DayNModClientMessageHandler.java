package com.encraft.dz.handlers;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class DayNModClientMessageHandler implements IMessageHandler<DayNModClientMessage, IMessage> {

	@Override
	public IMessage onMessage(DayNModClientMessage message, MessageContext ctx)
	{
		//Tu wpisa� co ma klient robi� po otrzymaniu pakietu
		return null;
	}
	
}
