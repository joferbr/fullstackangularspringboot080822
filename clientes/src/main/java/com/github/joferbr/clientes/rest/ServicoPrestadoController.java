package com.github.joferbr.clientes.rest;

import com.github.joferbr.clientes.model.entity.Cliente;
import com.github.joferbr.clientes.model.entity.ServicoPrestado;
import com.github.joferbr.clientes.model.repository.ClienteRepository;
import com.github.joferbr.clientes.model.repository.ServicoPrestadoRepository;
import com.github.joferbr.clientes.rest.dto.ServicoPrestadoDTO;
import com.github.joferbr.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    //O ServicoPrestadoController só funciona de as instâncias abaixo estiverem funcionando
    private final ClienteRepository clienteRepository;
    private final ServicoPrestadoRepository repository;
    private final BigDecimalConverter bigDecimalConverter;

    //Para deixar um código mais limpo, substitui-se o construtor abaixo por @RequiredArgsConstrutor
    //    public ServicoPrestadoController(
    //            ClienteRepository clienteRepository,
    //            ServicoPrestadoRepository servicoPrestadoRepository) {
    //        this.clienteRepository = clienteRepository;
    //        this.servicoPrestadoRepository = servicoPrestadoRepository;
    //    }

    //É preciso um construtor sem parâmetro para fazer uma instância com os dela para receber os dados do json
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody ServicoPrestadoDTO dto) {
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Integer idCliente = dto.getIdCliente();

        Cliente cliente = clienteRepository
                .findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Cliente inexistente."));
        //É Optional porque pode ou não existir o id do cliente, se não retorna um cliente novo
//        Optional<Cliente> clienteOptional = clienteRepository.findById(idCliente);
//        Cliente cliente = clienteOptional.orElse(new Cliente());//ou Optional<String> nomeOptional = clienteOptional
//                                                                //.map(c -> c.getNome());
//                                                                //ou clienteOptional.ifPresente(cliente -> {
//                                                                //System.out.println(cliente.getNome());
//                                                                //});
        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        servicoPrestado.setData(data);
        servicoPrestado.setCliente(cliente);
        servicoPrestado.setValor( bigDecimalConverter.converter(dto.getPreco()));
        return repository.save(servicoPrestado);
    }

    public List<ServicoPrestado> pesquisar(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ) {
        return repository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }


}
