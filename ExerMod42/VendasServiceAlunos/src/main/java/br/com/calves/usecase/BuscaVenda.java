package br.com.calves.usecase;

import br.com.calves.domain.Venda;
import br.com.calves.exception.EntityNotFoundException;
import br.com.calves.repository.IVendaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BuscaVenda {

    private IVendaRepository vendaRepository;

    @Autowired
    public BuscaVenda(IVendaRepository vendaRepository) {
        this.vendaRepository = vendaRepository;
    }

    public Page<Venda> buscar(Pageable pageable) {
        return vendaRepository.findAll(pageable);
    }

    public Venda buscarPorCodigo(String codigo) {
        return vendaRepository.findByCodigo(codigo).orElseThrow(() -> new EntityNotFoundException(Venda.class, "codigo", codigo));
    }


}
