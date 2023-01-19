package prr.app.clients;

import prr.Network;
import prr.app.exceptions.UnknownClientKeyException;
import prr.client.Client;
import prr.exceptions.ClientDontExistException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Show the payments and debts of a client.
 */
class DoShowClientPaymentsAndDebts extends Command<Network> {

	DoShowClientPaymentsAndDebts(Network receiver) {
		super(Label.SHOW_CLIENT_BALANCE, receiver);
		addStringField("clientKey", Prompt.key());
	}

	@Override
	protected final void execute() throws CommandException {
		try{
			Client client = _receiver.getClient(stringField("clientKey"));
			_display.popup(Message.clientPaymentsAndDebts(stringField("clientKey"),Math.round(client.getPaymentsValue()),Math.round(client.getDebtValue())));
		}catch (ClientDontExistException e){
			throw new UnknownClientKeyException(e.getKey());
		}
	}
}
