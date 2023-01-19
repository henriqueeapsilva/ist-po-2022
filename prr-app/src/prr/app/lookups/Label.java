package prr.app.lookups;

/**
 * Menu entries.
 */
interface Label {

	/** Menu title. */
	String TITLE = "CONSULTAS";

	/** List all calls. */
	String SHOW_ALL_COMMUNICATIONS = "Mostrar todas as comunicações";

	/** List calls from one client. */
	String SHOW_COMMUNICATIONS_FROM_CLIENT = "Mostrar comunicações feitas por um cliente";

	/** List calls to a client. */
	String SHOW_COMMUNICATIONS_TO_CLIENT = "Mostrar comunicações recebidas por um cliente";

	/** List clients with no debts. */
	String SHOW_CLIENTS_WITHOUT_DEBTS = "Mostrar clientes sem dívidas";

	/** List clients with debts. */
	String SHOW_CLIENTS_WITH_DEBTS = "Mostrar clientes com dívidas";

	/** List terminals with no activity. */
	String SHOW_UNUSED_TERMINALS = "Mostrar terminais sem actividade";

	/** List terminals with positive balance. */
	String SHOW_TERMINALS_WITH_POSITIVE_BALANCE = "Mostrar terminais com saldo positivo";

	/** Client wth lowest payment */
	String SHOW_CLIENT_WITH_LOWEST_PAYMENTS = "Mostrar client com menor valor pago";

	/** Terminal with highest payment */
	String SHOW_TERMINAL_WITH_HIGHEST_PAYMENT = "Mostrar terminal com maior valor pago";
}
