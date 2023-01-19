package prr.app.lookups;

import prr.Network;
import prr.app.exceptions.UnknownClientKeyException;
import prr.exceptions.ClientDontExistException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show communications from a client.
 */
class DoShowCommunicationsFromClient extends Command<Network> {

	DoShowCommunicationsFromClient(Network receiver) {
		super(Label.SHOW_COMMUNICATIONS_FROM_CLIENT, receiver);
		addStringField("clientKey",Prompt.clientKey());
	}

	@Override
	protected final void execute() throws CommandException {
        try {
			_display.popup(_receiver.getCommunicationFromClient(stringField("clientKey")));
		}catch (ClientDontExistException e){
			throw new UnknownClientKeyException(e.getKey());
		}
	}
}
