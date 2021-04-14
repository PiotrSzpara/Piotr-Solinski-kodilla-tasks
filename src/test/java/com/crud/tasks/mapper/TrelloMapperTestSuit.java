package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TrelloMapperTestSuit {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    void testMapToBoards() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "newList1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "newList2", true);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto1);
        trelloListDtos.add(trelloListDto2);

        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "newBoard1", trelloListDtos);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "newBoard2", trelloListDtos);
        List<TrelloBoardDto> testBoardDtos = new ArrayList<>();
        testBoardDtos.add(trelloBoardDto1);
        testBoardDtos.add(trelloBoardDto2);

        TrelloList trelloList1 = new TrelloList("1", "newList1", false);
        TrelloList trelloList2 = new TrelloList("2", "newList2", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);

        TrelloBoard testBoard1 = new TrelloBoard(trelloBoardDto1.getId(), trelloBoardDto1.getName(), trelloLists);
        TrelloBoard testBoard2 = new TrelloBoard(trelloBoardDto2.getId(), trelloBoardDto2.getName(), trelloLists);
        List<TrelloBoard> expectedBoard = new ArrayList<>();
        expectedBoard.add(testBoard1);
        expectedBoard.add(testBoard2);

        //When
        List<TrelloBoard> resultBoard = trelloMapper.mapToBoards(testBoardDtos);

        //Then
        assertEquals(expectedBoard.get(1).getName(), resultBoard.get(1).getName());
    }

    @Test
    void testMapToBoardsDto() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1", "newList1", true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2", "newList2", true);
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(trelloListDto1);
        trelloListDtos.add(trelloListDto2);

        TrelloBoardDto trelloBoardDto1 = new TrelloBoardDto("1", "newBoard1", trelloListDtos);
        TrelloBoardDto trelloBoardDto2 = new TrelloBoardDto("2", "newBoard2", trelloListDtos);
        List<TrelloBoardDto> expectedBoard = new ArrayList<>();
        expectedBoard.add(trelloBoardDto1);
        expectedBoard.add(trelloBoardDto2);

        TrelloList trelloList1 = new TrelloList("1", "newList1", false);
        TrelloList trelloList2 = new TrelloList("2", "newList2", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);

        TrelloBoard testBoard1 = new TrelloBoard(trelloBoardDto1.getId(), trelloBoardDto1.getName(), trelloLists);
        TrelloBoard testBoard2 = new TrelloBoard(trelloBoardDto2.getId(), trelloBoardDto2.getName(), trelloLists);
        List<TrelloBoard> testBoardDtos = new ArrayList<>();
        testBoardDtos.add(testBoard1);
        testBoardDtos.add(testBoard2);

        //When
        List<TrelloBoardDto> resultBoard = trelloMapper.mapToBoardsDto(testBoardDtos);

        //Then
        assertEquals(resultBoard.get(1).getName(), expectedBoard.get(1).getName());
    }

    @Test
    void testMapToList() {
        //Given
        TrelloListDto trelloListDto1 = new TrelloListDto("1","list1",true);
        TrelloListDto trelloListDto2 = new TrelloListDto("2","list2",true);
        List<TrelloListDto> trelloListDtos = new LinkedList<>();
        trelloListDtos.add(trelloListDto1);
        trelloListDtos.add(trelloListDto2);

        //When
        List<TrelloList> result = trelloMapper.mapToList(trelloListDtos);

        //Then
        assertEquals(result.get(1).getName(), trelloListDtos.get(1).getName());
    }

    @Test
    void testMapToListDto() {
        //Given
        TrelloList trelloList1 = new TrelloList("1", "newList1", false);
        TrelloList trelloList2 = new TrelloList("2", "newList2", false);
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(trelloList1);
        trelloLists.add(trelloList2);

        //When
        List<TrelloListDto> result = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(result.get(1).getName(), trelloLists.get(1).getName());
    }

    @Test
    void testMapToCard() {
        //Given

        TrelloCardDto trelloCardDto = new TrelloCardDto();
        trelloCardDto.setName("new name");

        //When
        TrelloCard result = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals(result.getName(), trelloCardDto.getName());
    }

    @Test
    void testMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard("new name", "new description", "new pos","new id");

        //When
        TrelloCardDto result = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(result.getName(), trelloCard.getName());

    }
}
