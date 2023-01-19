package prr.app.terminals;

import prr.Network;
import prr.app.exceptions.DuplicateTerminalKeyException;
import prr.app.exceptions.InvalidTerminalKeyException;
import prr.app.exceptions.UnknownClientKeyException;
import prr.exceptions.ClientDontExistException;
import prr.exceptions.TerminalAlreadyExistsException;
import prr.exceptions.TerminalKeyException;
import prr.exceptions.UnrecognizedEntryException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;
//FIXME add more imports if needed

/**
 * Register terminal.
 */
class DoRegisterTerminal extends Command<Network> {

	DoRegisterTerminal(Network receiver) {
		super(Label.REGISTER_TERMINAL, receiver);
		addStringField("key", Prompt.terminalKey());
		addOptionField("type", Prompt.terminalType(), "BASIC", "FANCY");
		addStringField("client", Prompt.clientKey());
	}

	@Override
	protected final void execute() throws CommandException {
		try {
			String terminalKey = stringField("key");
			String terminalType = optionField("type");
			String terminalClient = stringField("client");

			_receiver.registryTermianl( terminalType,terminalKey, terminalClient , null);

		}catch (TerminalAlreadyExistsException e){
			throw new DuplicateTerminalKeyException(e.getKey());
		}catch (TerminalKeyException e){
			throw new InvalidTerminalKeyException(e.getKey());
		}catch (ClientDontExistException e){
			throw new UnknownClientKeyException(e.getKey());
		}catch (UnrecognizedEntryException e) {
			e.printStackTrace();
		}
	}
}
