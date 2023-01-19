package prr.app.lookups;

import prr.Network;
import pt.tecnico.uilib.menus.Command;
import pt.tecnico.uilib.menus.CommandException;

public class DoShowClientWithLowestPayment extends Command<Network>{
    
    DoShowClientWithLowestPayment(Network receiver){
        super(Label.SHOW_CLIENT_WITH_LOWEST_PAYMENTS,receiver);
    }

    @Override
    public final void execute() throws CommandException{
        _display.popup(_receiver.getClientWithLowestPayment());
    }
}
