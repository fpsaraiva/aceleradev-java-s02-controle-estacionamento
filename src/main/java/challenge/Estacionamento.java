package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

	private List<Carro> carrosEstacionados = new ArrayList<>();
	int contadorMotoristasSenior = 0;

    public void estacionar(Carro carro) {
      if(carrosEstacionados.size() < 10) {
    	  if(carro.getMotorista() == null) {
    		  throw new EstacionamentoException("Nao sao permitidos entra carros autonomos");
    	  } else {
    		  carrosEstacionados.add(carro);
    	  }
      } else {
    	  for(Carro carroEstacionado : carrosEstacionados) {
    		  if(carroEstacionado.getMotorista().getIdade() < 55) {
    			  carrosEstacionados.remove(carroEstacionado);
    			  carrosEstacionados.add(carro);
    			  break;
    		  } else if(contadorMotoristasSenior == 9) {
    	          throw new EstacionamentoException("Todos os motoristas ja tem 55 anos");
              } else {
            	  contadorMotoristasSenior++;
              }
    	  }
      }
    }

    public int carrosEstacionados() {
        int vagasDeEstacionamentoOcupadas = carrosEstacionados.size();
    	return vagasDeEstacionamentoOcupadas;
    }

    public boolean carroEstacionado(Carro carro) {
        for (Carro carroEstacionado : carrosEstacionados) {
            if (carroEstacionado == carro) {
                return true;
            }
        }
        return false;
    }
}
