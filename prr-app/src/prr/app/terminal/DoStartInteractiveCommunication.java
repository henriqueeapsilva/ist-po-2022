package prr.app.terminal;

import prr.Network;
import prr.app.exceptions.UnknownTerminalKeyException;
import prr.exceptions.*;
import prr.terminals.Terminal;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.CommandException;
//FIXME add more imports if needed

/**
 * Command for starting communication.
 */
class DoStartInteractiveCommunication extends TerminalCommand {

	DoStartInteractiveCommunication(Network context, Terminal terminal) {
		super(Label.START_INTERACTIVE_COMMUNICATION, context, terminal, receiver -> receiver.canStartCommunication());
	}

	@Override
	protected final void execute() throws CommandException {
		try{
			Form request = new Form();
			request.addStringField("terminalKey",Prompt.terminalKey());
			request.addOptionField("comunicationType", Prompt.commType(), "VOICE", "VIDEO");
			request.parse();
			Terminal toTerminal = _network.getNetworkTerminal(request.stringField("terminalKey"));
			_receiver.startInteractiveComunication(_network.getCommunicationId(), toTerminal, request.stringField("comunicationType"));

		} catch (TerminalDontExistsException e) {
			throw new UnknownTerminalKeyException(e.getKey());
		} catch (DestinationTerminalUnsupportedException e) {
			_network.createCommunicationFailed();
			_display.popup(Message.unsupportedAtDestination(e.getKey(), e.getComType()));
		} catch (OriginTerminalUnsupportedException e) {
			_network.createCommunicationFailed();
			_display.popup(Message.unsupportedAtOrigin(e.getKey(), e.getComType()));
		}catch (DestinationTerminalOffException e){
			_network.createCommunicationFailed();
			_display.popup(Message.destinationIsOff(e.getKey()));
		}catch (DestinationTerminalIsBusyException e){
			_network.createCommunicationFailed();
			_display.popup(Message.destinationIsBusy(e.getKey()));
		}catch (DestinationTerminalIsSilenceException e){
			_network.createCommunicationFailed();
			_display.popup(Message.destinationIsSilent(e.getKey()));
		}
	}
}
