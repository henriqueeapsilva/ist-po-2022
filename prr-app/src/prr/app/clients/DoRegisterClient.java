package prr.app.clients;

import prr.Network;
import prr.app.exceptions.DuplicateClientKeyException;
import prr.exceptions.ClientAlreadyExitsException;
import prr.exceptions.UnrecognizedEntryException;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Register new client.
 */
class DoRegisterClient extends Command<Network> {

	DoRegisterClient(Network receiver) {
		super(Label.REGISTER_CLIENT, receiver);
        addStringField("key", Prompt.key());
		addStringField("name", Prompt.name());
		addIntegerField("nif", Prompt.taxId());
	}

	@Override
	protected final void execute() throws CommandException {
		try {
			//String type = Form.requestString(Prompt.());
			String clientKey = stringField("key");
			String clientName = stringField("name");
			Integer taxId = integerField("nif");

			_receiver.registryClient(null, clientKey, clientName, taxId.toString());

		} catch (ClientAlreadyExitsException e){
			throw new DuplicateClientKeyException(e.getKey());}
		catch (UnrecognizedEntryException e){e.printStackTrace();}
	}

}
