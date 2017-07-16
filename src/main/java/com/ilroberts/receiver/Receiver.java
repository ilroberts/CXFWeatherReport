package com.ilroberts.receiver;


import com.ilroberts.dto.TableDTO;

import java.util.List;

public interface Receiver<T> {

    List<TableDTO> receive();
}
