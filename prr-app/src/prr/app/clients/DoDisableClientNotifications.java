package prr.app.clients;

import prr.Network;
import prr.app.exceptions.UnknownClientKeyException;
import prr.exceptions.ClientDontExistException;
import prr.exceptions.ClientNotificationsAlreadyDisable;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME add more imports if needed

/**
 * Disable client notifications.
 */
class DoDisableClientNotifications extends Command<Network> {

	DoDisableClientNotifications(Network receiver) {
		super(Label.DISABLE_CLIENT_NOTIFICATIONS, receiver);
		addStringField("clientKey", Prompt.key());
	}

	@Override
	protected final void execute() throws CommandException {
		try {
			_receiver.getClient(stringField("clientKey")).disableClientNotifications();
		}catch (ClientNotificationsAlreadyDisable e){
			_display.popup(Message.clientNotificationsAlreadyDisabled());
		}catch (ClientDontExistException e){
			throw new UnknownClientKeyException(e.getKey());
		}
	}
}
