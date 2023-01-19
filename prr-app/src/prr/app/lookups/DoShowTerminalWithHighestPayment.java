package prr.app.lookups;

import prr.Network;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

public class DoShowTerminalWithHighestPayment extends Command<Network>{
    
    DoShowTerminalWithHighestPayment(Network receiver){
        super(Label.SHOW_TERMINAL_WITH_HIGHEST_PAYMENT,receiver);
    }

    @Override
    public final void execute() throws CommandException{
        _display.popup(_receiver.getTerminalWithHighestPayments());
    }
}
