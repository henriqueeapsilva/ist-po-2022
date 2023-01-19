package prr.app.terminal;

import prr.Network;
import prr.app.exceptions.InvalidTerminalKeyException;
import prr.app.exceptions.UnknownTerminalKeyException;
import prr.exceptions.TerminalDontExistsException;
import prr.exceptions.TerminalKeyException;
import prr.terminals.Terminal;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Add a friend.
 */
class DoAddFriend extends TerminalCommand {

	DoAddFriend(Network context, Terminal terminal) {
		super(Label.ADD_FRIEND, context, terminal);
		addStringField("terminalKey", Prompt.terminalKey());
	}

	@Override
	protected final void execute() throws CommandException {
		try{
			_network.verifyTerminalKey(stringField("terminalKey"));
			_network.verifyTerminalKeyExists(stringField("terminalKey"));
			_receiver.addTerminalFriend(stringField("terminalKey"), _network.getNetworkTerminal(stringField("terminalKey")));

		}catch (TerminalKeyException e) {
			throw new InvalidTerminalKeyException(e.getKey());
		}catch (TerminalDontExistsException e){
			throw new UnknownTerminalKeyException(e.getKey());
		}

	}
}
