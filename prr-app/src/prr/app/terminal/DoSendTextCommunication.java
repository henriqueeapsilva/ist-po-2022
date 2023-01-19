package prr.app.terminal;

import prr.Network;
import prr.exceptions.DestinationTerminalOffException;
import prr.exceptions.TerminalDontExistsException;
import prr.terminals.Terminal;
import prr.app.exceptions.UnknownTerminalKeyException;
import pt.tecnico.uilib.forms.Form;
import pt.tecnico.uilib.menus.CommandException;

/**
 * Command for sending a text communication.
 */
class DoSendTextCommunication extends TerminalCommand {

        DoSendTextCommunication(Network context, Terminal terminal) {
                super(Label.SEND_TEXT_COMMUNICATION, context, terminal, receiver -> receiver.canStartCommunication());
        }

        @Override
        protected final void execute() throws CommandException {
                try{
                        Form request = new Form();
                        request.addStringField("terminalKey", Prompt.terminalKey());
                        request.addStringField("message", Prompt.textMessage());
                        request.parse();
                        _receiver.sendTextCommunication( _network.getNetworkTerminal(request.stringField("terminalKey")),_network.getCommunicationId(), request.stringField("message"));
                } catch (TerminalDontExistsException e) {
                        throw new UnknownTerminalKeyException(e.getKey());
                } catch (DestinationTerminalOffException e){
                        _network.createCommunicationFailed();
                        _display.popup(Message.destinationIsOff(e.getKey()));
                }
        }
} 
