package prr.app.clients;

import prr.Network;
import prr.app.exceptions.UnknownClientKeyException;
import prr.exceptions.ClientDontExistException;
import prr.exceptions.ClientNotificationsAlreadyEnable;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME add more imports if needed

/**
 * Enable client notifications.
 */
class DoEnableClientNotifications extends Command<Network> {

	DoEnableClientNotifications(Network receiver) {
		super(Label.ENABLE_CLIENT_NOTIFICATIONS, receiver);
		addStringField("clientKey", Prompt.key());
	}

	@Override
	protected final void execute() throws CommandException {
		try {
			_receiver.getClient(stringField("clientKey")).enableClientNotifications();
		} catch (ClientNotificationsAlreadyEnable e) {
			_display.popup(Message.clientNotificationsAlreadyEnabled());
		} catch (ClientDontExistException e) {
			throw new UnknownClientKeyException(e.getKey());
		}
	}
}
